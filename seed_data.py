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

def seed_cuentas():
    print("\n[Paso Empresa y Cuentas] Registrando Empresa y Cuentas Contables en tablas maestras...")
    
    # Empresa E001
    send_request("/empresas", "POST", {
        "empresaId": "E001",
        "empresaDescripcion": "VitalFarma Farmacia y Botica",
        "empresaRazSocial": "VitalFarma S.A.C.",
        "empresaTelef01": "01-4567890",
        "empresaTelef02": "",
        "empresaTelef03": "",
        "empresaRUC": "20601234567",
        "empresaFax": "",
        "dptoGeoId": "15",
        "provGeoId": "01",
        "distGeoId": "01",
        "empresaDirecc": "Av. Larco 123, Miraflores, Lima",
        "empresaAbrev": "VF",
        "empresaFicEle": "",
        "empresaRubro": "Farmacéutico y Salud",
        "empresaEst": True,
        "usrSistema": "admin",
        "hrsSistema": "12:00:00",
        "empresaMail": "contacto@vitalfarma.com",
        "empFileNameFirma": "",
        "empRepLegal": "Luis Osio"
    })
    
    # Cuenta 12
    send_request("/cuenta", "POST", {"cuentaId": "12", "cuentaDescripcion": "Cuentas por Cobrar Comerciales - Terceros", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "12", "subCtaId": "121", "subCtaDescripcion": "Facturas, Boletas y Otros Comprobantes por Cobrar", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "12", "subCtaId": "121", "divisioId": "1212", "divisioDescripcion": "Emitidas en Cartera", "divisioEstad": True, "usrSistema": "admin"})
    
    # Cuenta 40
    send_request("/cuenta", "POST", {"cuentaId": "40", "cuentaDescripcion": "Tributos, Contraprestaciones y Aportes al Sistema de Pensiones y de Salud por Pagar", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "40", "subCtaId": "401", "subCtaDescripcion": "Gobierno Nacional", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "40", "subCtaId": "401", "divisioId": "4011", "divisioDescripcion": "Impuesto General a las Ventas", "divisioEstad": True, "usrSistema": "admin"})
    send_request("/subdivisionaria", "POST", {"cuentaId": "40", "subCtaId": "401", "divisioId": "4011", "subDivId": "40111", "subDivDescripcion": "IGV - Cuenta Propia", "subDivEstado": True, "usrSistema": "admin", "tipCtaId": 1, "subDivNumDigSunat": 5})

    # Cuenta 70
    send_request("/cuenta", "POST", {"cuentaId": "70", "cuentaDescripcion": "Ventas", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "70", "subCtaId": "701", "subCtaDescripcion": "Mercaderías", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "70", "subCtaId": "701", "divisioId": "7011", "divisioDescripcion": "Mercaderías Manufacturadas - Terceros", "divisioEstad": True, "usrSistema": "admin"})
    
    # Cuenta 10
    send_request("/cuenta", "POST", {"cuentaId": "10", "cuentaDescripcion": "Efectivo y Equivalentes de Efectivo", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "10", "subCtaId": "101", "subCtaDescripcion": "Caja", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "10", "subCtaId": "101", "divisioId": "1011", "divisioDescripcion": "Caja General", "divisioEstad": True, "usrSistema": "admin"})
    
    # Cuenta 20
    send_request("/cuenta", "POST", {"cuentaId": "20", "cuentaDescripcion": "Mercaderías", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "20", "subCtaId": "201", "subCtaDescripcion": "Mercaderías", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "20", "subCtaId": "201", "divisioId": "2011", "divisioDescripcion": "Mercaderías Manufacturadas", "divisioEstad": True, "usrSistema": "admin"})
    
    # Cuenta 60
    send_request("/cuenta", "POST", {"cuentaId": "60", "cuentaDescripcion": "Compras", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "60", "subCtaId": "601", "subCtaDescripcion": "Mercaderías", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "60", "subCtaId": "601", "divisioId": "6011", "divisioDescripcion": "Mercaderías Manufacturadas", "divisioEstad": True, "usrSistema": "admin"})
    
    # Cuenta 61
    send_request("/cuenta", "POST", {"cuentaId": "61", "cuentaDescripcion": "Variación de Inventarios", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "61", "subCtaId": "611", "subCtaDescripcion": "Mercaderías", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "61", "subCtaId": "611", "divisioId": "6111", "divisioDescripcion": "Mercaderías Manufacturadas", "divisioEstad": True, "usrSistema": "admin"})

    # Cuenta 69
    send_request("/cuenta", "POST", {"cuentaId": "69", "cuentaDescripcion": "Costo de Ventas", "cuentaEstado": True, "usrSistema": "admin"})
    send_request("/subcuenta", "POST", {"cuentaId": "69", "subCtaId": "691", "subCtaDescripcion": "Mercaderías", "subCtaEstado": True, "usrSistema": "admin"})
    send_request("/divisionaria", "POST", {"cuentaId": "69", "subCtaId": "691", "divisioId": "6911", "divisioDescripcion": "Mercaderías Manufacturadas - Terceros", "divisioEstad": True, "usrSistema": "admin"})
    
    print("  -> Cuentas maestras sembradas con éxito.")

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
    if isinstance(login_res, dict) and "error_status" in login_res:
        print(f"  [Error] Error de login: {login_res}")
        return
    
    if isinstance(login_res, dict) and "token" in login_res:
        TOKEN = login_res["token"]
        print("  -> Token JWT obtenido con éxito.")
    elif isinstance(login_res, str):
        TOKEN = login_res.strip()
        print("  -> Token JWT obtenido con éxito.")
    else:
        TOKEN = str(login_res)
        print("  -> Token JWT obtenido con éxito.")

    # Sembrar Cuentas Maestras
    seed_cuentas()

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
        "clienDescripcion": "Droguería Médica del Norte",
        "clienRazSoc": "Droguería Médica del Norte S.A.C.",
        "clienNomCor": "Droguería Médica",
        "clienSiglas": "DMN",
        "tipDocIdenId": tipo_doc_id,
        "clienDoc": "20609876543",
        "clienRegCom": "REG-1045",
        "clienDireccion": "Av. Los Tulipanes 450, Chiclayo",
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
    print("\n[Paso 5] Creando Comprobantes de Pago (Factura y Boleta)...")
    com_pago_payload_fac = {
        "id": "01",
        "comPagDescripcion": "Factura",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    com_pago_fac = send_request("/comprobantespago", "POST", com_pago_payload_fac)
    print(f"  -> Factura: {com_pago_fac}")

    com_pago_payload_bol = {
        "id": "03",
        "comPagDescripcion": "Boleta",
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    com_pago_bol = send_request("/comprobantespago", "POST", com_pago_payload_bol)
    print(f"  -> Boleta: {com_pago_bol}")

    # 6. Crear Documento
    print("\n[Paso 6] Creando Documentos de Venta...")
    documento_payload_fac = {
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
    documento_fac = send_request("/documentos", "POST", documento_payload_fac)
    print(f"  -> Factura de Venta: {documento_fac}")

    documento_payload_bol = {
        "id": "03",
        "docDescripcion": "Boleta de Venta",
        "docDesCorta": "BOL",
        "docAbrev": "B",
        "docEstado": True,
        "comPagId": "03",
        "docNumDigSerie": 4,
        "docNumDigNumero": 8,
        "docAfaNumerico": True,
        "usrSistema": "admin",
        "fecSistema": "2026-07-08T10:00:00",
        "hrsSistema": "10:00:00"
    }
    documento_bol = send_request("/documentos", "POST", documento_payload_bol)
    print(f"  -> Boleta de Venta: {documento_bol}")

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
    print("\n[Paso 8] Creando Laboratorios...")
    laboratorios = [
        {"labDescripcion": "Bayer", "labEstado": True, "codlab": "BAYER"},
        {"labDescripcion": "Pfizer", "labEstado": True, "codlab": "PFIZER"},
        {"labDescripcion": "Abbott", "labEstado": True, "codlab": "ABBOTT"},
        {"labDescripcion": "Genfar", "labEstado": True, "codlab": "GENFAR"},
        {"labDescripcion": "Sanofi", "labEstado": True, "codlab": "SANOFI"},
    ]
    created_labs = []
    for l_payload in laboratorios:
        l_payload.update({
            "usrSistema": "admin",
            "fecSistema": "2026-07-08T10:00:00",
            "hrsSistema": "10:00:00"
        })
        l_res = send_request("/laboratorios", "POST", l_payload)
        created_labs.append(l_res)
        print(f"  -> Laboratorio creado: {l_res.get('labDescripcion')} (ID: {l_res.get('id')})")
    
    # 9. Crear Familia de Producto
    print("\n[Paso 9] Creando Familias de Producto...")
    familias = [
        {"famDescripcion": "Analgésicos y Antiinflamatorios", "famEstado": True, "codfam": "ANALG"},
        {"famDescripcion": "Antibióticos", "famEstado": True, "codfam": "ANTIB"},
        {"famDescripcion": "Antihistamínicos", "famEstado": True, "codfam": "ANTIH"},
        {"famDescripcion": "Vitaminas y Suplementos", "famEstado": True, "codfam": "VITAM"},
        {"famDescripcion": "Antigripales", "famEstado": True, "codfam": "GRIPA"},
    ]
    created_fams = []
    for f_payload in familias:
        f_payload.update({
            "usrSistema": "admin",
            "fecSistema": "2026-07-08T10:00:00",
            "hrsSistema": "10:00:00"
        })
        f_res = send_request("/familias-producto", "POST", f_payload)
        created_fams.append(f_res)
        print(f"  -> Familia creada: {f_res.get('famDescripcion')} (ID: {f_res.get('id')})")

    # [Paso Grupo y Clase Almacen] Creando Grupos y Clases de Almacén
    print("\n[Paso Grupo y Clase Almacen] Creando Grupos y Clases de Almacén...")
    grupos_almacen = [
        {
            "id": "G01",
            "grpAlmDescripcion": "Medicamentos Controlados",
            "cuentaId": "20",
            "subCtaId": "2011",
            "divisioId": "20111",
            "subDivId": "201111",
            "codtip": "TIP01",
            "grpAlmEstado": True,
            "grpAlmCtaExistencia": "201111",
            "grpAlmCtaVarExistencia": "611111"
        },
        {
            "id": "G02",
            "grpAlmDescripcion": "Venta Libre (OTC)",
            "cuentaId": "20",
            "subCtaId": "2011",
            "divisioId": "20111",
            "subDivId": "201111",
            "codtip": "TIP02",
            "grpAlmEstado": True,
            "grpAlmCtaExistencia": "201111",
            "grpAlmCtaVarExistencia": "611111"
        }
    ]
    for ga in grupos_almacen:
        ga.update({
            "usrSistema": "admin",
            "fecSistema": "2026-07-08T10:00:00",
            "hrsSistema": "10:00:00"
        })
        res_ga = send_request("/grupos-almacen", "POST", ga)
        print(f"  -> Grupo Almacén creado: {res_ga.get('grpAlmDescripcion')} (ID: {res_ga.get('id')})")

    clases_almacen = [
        {
            "id": "C01",
            "grpAlmId": "G01",
            "clsAlmDescripcion": "Líquidos y Jarabes",
            "clsAlmEstado": True
        },
        {
            "id": "C02",
            "grpAlmId": "G02",
            "clsAlmDescripcion": "Sólidos (Tabletas/Cápsulas)",
            "clsAlmEstado": True
        }
    ]
    for ca in clases_almacen:
        ca.update({
            "usrSistema": "admin",
            "fecSistema": "2026-07-08T10:00:00",
            "hrsSistema": "10:00:00"
        })
        res_ca = send_request("/clases-almacen", "POST", ca)
        print(f"  -> Clase Almacén creada: {res_ca.get('clsAlmDescripcion')} (ID: {res_ca.get('id')})")

    # 10. Crear Productos
    print("\n[Paso 10] Creando Productos...")
    def find_id(lst, name_key, query):
        for item in lst:
            if query.lower() in item.get(name_key, "").lower():
                return item.get("id")
        return lst[0].get("id") if lst else 1

    bayer_id = find_id(created_labs, "labDescripcion", "Bayer")
    pfizer_id = find_id(created_labs, "labDescripcion", "Pfizer")
    abbott_id = find_id(created_labs, "labDescripcion", "Abbott")
    genfar_id = find_id(created_labs, "labDescripcion", "Genfar")

    analg_id = find_id(created_fams, "famDescripcion", "Analgésicos")
    antib_id = find_id(created_fams, "famDescripcion", "Antibióticos")
    antih_id = find_id(created_fams, "famDescripcion", "Antihistamínicos")
    vitam_id = find_id(created_fams, "famDescripcion", "Vitaminas")
    gripa_id = find_id(created_fams, "famDescripcion", "Antigripales")

    productos_data = [
        {
            "codpro": "PROD01",
            "iteAlmDescResumen": "Ibuprofeno 400mg",
            "iteAlmDescDetalle": "Ibuprofeno 400mg Tabletas",
            "iteAlmUso": "Dolor e inflamación",
            "iteAlmPrecio": 0.80,
            "iteAlmCosPro": 0.35,
            "labId": bayer_id,
            "famId": analg_id
        },
        {
            "codpro": "PROD02",
            "iteAlmDescResumen": "Amoxicilina 500mg",
            "iteAlmDescDetalle": "Amoxicilina 500mg Cápsulas",
            "iteAlmUso": "Infecciones bacterianas",
            "iteAlmPrecio": 1.20,
            "iteAlmCosPro": 0.50,
            "labId": genfar_id,
            "famId": antib_id
        },
        {
            "codpro": "PROD03",
            "iteAlmDescResumen": "Cetirizina 10mg",
            "iteAlmDescDetalle": "Cetirizina 10mg Tabletas recubiertas",
            "iteAlmUso": "Alergias y rinitis",
            "iteAlmPrecio": 0.50,
            "iteAlmCosPro": 0.15,
            "labId": pfizer_id,
            "famId": antihist_id if 'antihist_id' in locals() else antih_id
        },
        {
            "codpro": "PROD04",
            "iteAlmDescResumen": "Redoxon Vitamina C",
            "iteAlmDescDetalle": "Redoxon Vitamina C 1g Efervescente",
            "iteAlmUso": "Suplemento vitamínico",
            "iteAlmPrecio": 3.50,
            "iteAlmCosPro": 1.80,
            "labId": bayer_id,
            "famId": vitam_id
        },
        {
            "codpro": "PROD05",
            "iteAlmDescResumen": "Panadol Antigripal",
            "iteAlmDescDetalle": "Panadol Antigripal Multi-síntomas",
            "iteAlmUso": "Fiebre y congestión nasal",
            "iteAlmPrecio": 1.80,
            "iteAlmCosPro": 0.90,
            "labId": abbott_id,
            "famId": gripa_id
        }
    ]

    created_products = []
    for idx, p_data in enumerate(productos_data):
        p_payload = {
            "grpAlmId": "G01",
            "clsAlmId": "C01",
            "iteAlmCodBarra": f"77500000000{idx+1}",
            "labId": p_data["labId"],
            "famId": p_data["famId"],
            "comGenId": 1,
            "iteAlmDescDetalle": p_data["iteAlmDescDetalle"],
            "iteAlmDescResumen": p_data["iteAlmDescResumen"],
            "iteAlmUso": p_data["iteAlmUso"],
            "iteAlmUniMed": "UNIDAD",
            "iteAlmCtaCompra": "6011",
            "iteAlmCtaEntMat": "2011",
            "iteAlmCtaExist": "2011",
            "iteAlmPrecio": p_data["iteAlmPrecio"],
            "monedaId": moneda_id,
            "iteAlmUltFecAdq": "2026-07-08T10:00:00",
            "iteAlmEstado": True,
            "iteAlmStockMin": 10.00,
            "iteAlmTasIGV": 18.00,
            "iteAlmTasISC": 0.00,
            "iteAlmControlado": False,
            "iteAlmFraccUni": 1,
            "iteAlmCosPro": p_data["iteAlmCosPro"],
            "iteAlmDscto": 0.00,
            "iteAlmDsctoAdi": 0.00,
            "iteAlmUtilidadVta": round(((p_data["iteAlmPrecio"] - p_data["iteAlmCosPro"]) / p_data["iteAlmPrecio"]) * 100, 2),
            "iteAlmUtilidadSug": round(((p_data["iteAlmPrecio"] - p_data["iteAlmCosPro"]) / p_data["iteAlmPrecio"]) * 100, 2),
            "iteAlmPVPF": p_data["iteAlmPrecio"],
            "iteAlmPreVta": p_data["iteAlmPrecio"],
            "iteAlmValorVtaFar": round(p_data["iteAlmPrecio"] / 1.18, 2),
            "iteAlmFecVen": "2028-07-08T10:00:00",
            "codpro": p_data["codpro"],
            "itemAlmCtrlAdm": False,
            "unidMedId": "NIU",
            "usrSistema": "admin",
            "fecSistema": "2026-07-08T10:00:00",
            "hrsSistema": "10:00:00"
        }
        prod_res = send_request("/productos", "POST", p_payload)
        created_products.append(prod_res)
        print(f"  -> Producto creado: {prod_res.get('iteAlmDescResumen')} (ID: {prod_res.get('iteAlmId')})")
    
    producto_id = created_products[0].get("iteAlmId") if created_products else 1

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
                "vtaDetItem": "Ibuprofeno 400mg",
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
