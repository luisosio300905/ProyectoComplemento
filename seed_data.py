import json
import urllib.request
import urllib.error
import ssl

BASE_URL = "http://localhost:8080/api"
TOKEN = None

# Bypass SSL verification if any
ssl_context = ssl._create_unverified_context()

def send_request(path, method="POST", data=None):
    global TOKEN
    url = f"{BASE_URL}{path}"
    headers = {
        "Content-Type": "application/json",
        "Accept": "application/json"
    }
    if TOKEN:
        headers["Authorization"] = f"Bearer {TOKEN}"
        
    req_data = json.dumps(data).encode("utf-8") if data else None
    req = urllib.request.Request(url, data=req_data, headers=headers, method=method)
    
    try:
        with urllib.request.urlopen(req, context=ssl_context) as response:
            res_data = response.read().decode("utf-8")
            if response.status in (200, 201):
                try:
                    return json.loads(res_data)
                except json.JSONDecodeError:
                    return res_data
            elif response.status == 240: # No content or similar custom statuses
                return None
            return res_data
    except urllib.error.HTTPError as e:
        res_data = e.read().decode("utf-8")
        # Try to parse as JSON error
        try:
            parsed = json.loads(res_data)
            return {"error_status": e.code, "error_body": parsed}
        except:
            return {"error_status": e.code, "error_body": res_data}
    except Exception as e:
        return {"error": str(e)}

def run_seeding():
    global TOKEN
    print("="*60)
    print("INICIANDO AUTOMATIZACIÓN DE SEEDING Y PRUEBAS CONTABLES")
    print("="*60)
    
    # 1. Registrar usuario de prueba
    print("\n[Paso 1] Registrando usuario 'admin'...")
    user_payload = {
        "nombre": "admin",
        "contrasenia": "admin123"
    }
    res = send_request("/auth/register", "POST", user_payload)
    if isinstance(res, dict) and "error_status" in res:
        print(f"  -> Nota: Registro omitido o error ({res['error_status']}): {res['error_body']}")
    else:
        print(f"  -> Usuario registrado: {res}")
        
    # 2. Hacer Login para obtener el Token JWT
    print("\n[Paso 2] Autenticando para obtener Token JWT...")
    login_res = send_request("/auth/login", "POST", user_payload)
    if isinstance(login_res, str):
        TOKEN = login_res.strip()
        print("  -> Token JWT obtenido con éxito.")
    elif isinstance(login_res, dict) and "error_status" in login_res:
        print(f"  ❌ Error de login: {login_res}")
        return
    else:
        TOKEN = str(login_res)
        print("  -> Token JWT obtenido con éxito.")

    # 3. Crear Tipo de Documento de Identidad (DNI)
    print("\n[Paso 3] Creando Tipo de Documento de Identidad (DNI)...")
    tipo_doc_payload = {
        "nombre": "DNI"
    }
    tipo_doc = send_request("/tiposdocumento", "POST", tipo_doc_payload)
    print(f"  -> Resultado: {tipo_doc}")
    tipo_doc_id = tipo_doc.get("id") if isinstance(tipo_doc, dict) else 1
    
    # 4. Crear Cliente
    print("\n[Paso 4] Creando Cliente...")
    cliente_payload = {
        "clienDescripcion": "Cliente de prueba",
        "clienRazSoc": "Pruebas S.A.C.",
        "clienNomCor": "Pruebas",
        "clienSiglas": "PRU",
        "tipDocIdenId": tipo_doc_id,
        "clienDoc": "10203040",
        "clienRegCom": "REG-01",
        "clienDireccion": "Av. Principal 123",
        "clienTelef01": "555-1234",
        "clienCelular": "999888777",
        "clienMail": "cliente@pruebas.com",
        "clienWeb": "www.pruebas.com",
        "clienContacto": "Juan Pérez",
        "clienFecIng": "2026-07-08T10:00:00",
        "clienEstado": "A",
        "clienGiro": "Comercio",
        "ctaCteId": 1,
        "dptoGeoId": "15",
        "provGeoId": "01",
        "distGeoId": "01",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    cliente = send_request("/clientes", "POST", cliente_payload)
    print(f"  -> Resultado: {cliente}")
    cliente_id = cliente.get("id") if isinstance(cliente, dict) else 1

    # 5. Crear Comprobante de Pago
    print("\n[Paso 5] Creando Comprobante de Pago (Factura)...")
    com_pago_payload = {
        "id": "01",
        "comPagDescripcion": "Factura",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    com_pago = send_request("/comprobantespago", "POST", com_pago_payload)
    print(f"  -> Resultado: {com_pago}")

    # 6. Crear Documento
    print("\n[Paso 6] Creando Documento de Venta...")
    documento_payload = {
        "id": "01",
        "docDescripcion": "Factura de Venta",
        "docDesCorta": "FAC",
        "docAbrev": "F",
        "docEstado": True,
        "comPagId": "01",
        "docNumDigSerie": 4,
        "docNumDigNumero": 8,
        "docAfaNumerico": True,
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    documento = send_request("/documentos", "POST", documento_payload)
    print(f"  -> Resultado: {documento}")

    # 7. Crear Moneda
    print("\n[Paso 7] Creando Moneda (Soles)...")
    moneda_payload = {
        "monedaDescripcion": "Soles",
        "monedaAbrev": "S/.",
        "monedaEst": True,
        "monedaAbrevSunat": "PEN",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    moneda = send_request("/monedas", "POST", moneda_payload)
    print(f"  -> Resultado: {moneda}")
    moneda_id = moneda.get("id") if isinstance(moneda, dict) else 1

    # 8. Crear Laboratorio
    print("\n[Paso 8] Creando Laboratorio...")
    lab_payload = {
        "labDescripcion": "Laboratorio Genérico",
        "labEstado": True,
        "codlab": "LAB01",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    lab = send_request("/laboratorios", "POST", lab_payload)
    print(f"  -> Resultado: {lab}")
    lab_id = lab.get("id") if isinstance(lab, dict) else 1

    # 9. Crear Familia de Producto
    print("\n[Paso 9] Creando Familia de Producto...")
    fam_payload = {
        "famDescripcion": "Medicamentos",
        "famEstado": True,
        "codfam": "FAM01",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    fam = send_request("/familias-producto", "POST", fam_payload)
    print(f"  -> Resultado: {fam}")
    fam_id = fam.get("id") if isinstance(fam, dict) else 1

    # 10. Crear Producto
    print("\n[Paso 10] Creando Producto (Paracetamol)...")
    producto_payload = {
        "grpAlmId": "G01",
        "clsAlmId": "C01",
        "iteAlmCodBarra": "7750123456789",
        "labId": lab_id,
        "famId": fam_id,
        "comGenId": 1,
        "iteAlmDescDetalle": "Paracetamol 500mg",
        "iteAlmDescResumen": "Paracetamol",
        "iteAlmUso": "Fiebre y dolor",
        "iteAlmUniMed": "UNIDAD",
        "iteAlmCtaCompra": "6011",
        "iteAlmCtaEntMat": "2011",
        "iteAlmCtaExist": "2011",
        "iteAlmPrecio": 1.50,
        "monedaId": moneda_id,
        "iteAlmUltFecAdq": "2026-07-08T10:00:00",
        "iteAlmEstado": True,
        "iteAlmStockMin": 10.00,
        "iteAlmTasIGV": 18.00,
        "iteAlmTasISC": 0.00,
        "iteAlmControlado": False,
        "iteAlmFraccUni": 1,
        "iteAlmCosPro": 0.80,
        "iteAlmDscto": 0.00,
        "iteAlmDsctoAdi": 0.00,
        "iteAlmUtilidadVta": 46.67,
        "iteAlmUtilidadSug": 46.67,
        "iteAlmPVPF": 1.50,
        "iteAlmPreVta": 1.50,
        "iteAlmValorVtaFar": 1.27,
        "iteAlmFecVen": "2028-07-08T10:00:00",
        "codpro": "PROD01",
        "itemAlmCtrlAdm": False,
        "unidMedId": "NIU",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    producto = send_request("/productos", "POST", producto_payload)
    print(f"  -> Resultado: {producto}")
    producto_id = producto.get("iteAlmId") if isinstance(producto, dict) else 1

    # 11. Crear Venta con Detalles Anidados
    print("\n[Paso 11] Creando Venta con detalles anidados y Asiento Contable automático...")
    venta_payload = {
        "empresaId": "E001",
        "unidComId": 1,
        "docId": "01",
        "vtaCabNumComp": "F001-000099",
        "clienId": cliente_id,
        "monedaId": moneda_id,
        "vtaCabFecha": "2026-07-08T10:30:00",
        "vtaValCamb": 3.75,
        "vtaCabAccImp": "S",
        "vtaComAccAnu": "N",
        "condComId": 1,
        "vtaCabEstCanc": "C",
        "vtaCabCierre": "N",
        "vtaCabActPlla": "N",
        "vtaCabAfecDetrac": "N",
        "vtaCabContDetrac": "N",
        "tipOpeComId": 1,
        "vtaCabValorVta": 1271.19,
        "vtaCabValorVtaExo": 0.00,
        "vtaCabValIGV": 228.81,
        "vtaCabValISC": 0.00,
        "vtaCabValTotal": 1500.00,
        "vtaCabValMonPago": 1500.00,
        "vtaCabValVuelto": 0.00,
        "vtaCabNamePaciente": "Paciente de Prueba",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:30:00",
        "hrsSistema": "10:30:00",
        "vtaCabDsctoGlobal": 0.00,
        "vtaCabFechaVcto": "2026-08-08T10:30:00",
        "detallesVenta": [
            {
                "empresaId": "E001",
                "unidComId": 1,
                "docId": "01",
                "vtaCabNumComp": "F001-000099",
                "iteAlmId": producto_id,
                "vtaDetCodref": 1,
                "vtaDetItem": "Paracetamol 500mg",
                "vtaDetCantidad": 10.00,
                "vtaDetPrecUnit": 150.00,
                "vtaDetValorVta": 1271.19,
                "vtaDetValIGV": 228.81,
                "vtaDetValISC": 0.00,
                "vtaDetValTot": 1500.00,
                "tipVtaId": 1,
                "tipAlmId": 1,
                "almacenId": 1,
                "vtaDetFracUni": 1,
                "vtaDetCantFrac": 0,
                "usrSistema": "admin",
                "fecSistema": "2026-07-08T10:30:00",
                "hrsSistema": "10:30:00",
                "vtaDetValIna": 0.00
            }
        ]
    }
    
    venta_res = send_request("/ventas", "POST", venta_payload)
    print(f"  -> Resultado Venta con Balance:\n{json.dumps(venta_res, indent=2)}")
    
    if isinstance(venta_res, dict) and "diaCabCompId" in venta_res:
        dia_cab_comp_id = venta_res["diaCabCompId"]
        
        # 12. Consultar Balance del Asiento Específico
        print(f"\n[Paso 12] Consultando Balance del Asiento Contable #{dia_cab_comp_id}...")
        balance_asiento = send_request(f"/balance-general/{dia_cab_comp_id}", "GET")
        print(f"  -> Resultado:\n{json.dumps(balance_asiento, indent=2)}")
        
        # 13. Consultar Balance General Completo del Periodo
        print("\n[Paso 13] Consultando Balance General de la Empresa E001...")
        balance_periodo = send_request("/balance-general?empresaId=E001&ano=2026&mes=7", "GET")
        print(f"  -> Resultado:\n{json.dumps(balance_periodo, indent=2)}")
        
    print("\n" + "="*60)
    print("PROCESO DE SEEDING Y PRUEBAS FINALIZADO CON ÉXITO")
    print("="*60)

if __name__ == "__main__":
    run_seeding()
