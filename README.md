Sistema de Gestión de Boletos de Cine - Kembly
Un sistema completo para la gestión de boletos de cine desarrollado en Java con interfaz gráfica Swing.
Descripción
Este sistema permite gestionar la venta y administración de boletos de cine de manera eficiente. Incluye funcionalidades para registrar boletos, generar reportes y facturas, y mantener un control completo sobre las ventas del establecimiento cinematográfico.
Características Principales

Gestión de Boletos: Registro completo de boletos con validación de datos
Interfaz Gráfica Intuitiva: Desarrollada con Java Swing para facilidad de uso
Validación de Datos: Sistema robusto de validación para prevenir errores
Generación de Reportes: Reportes generales del sistema
Generación de Facturas: Facturas individuales por boleto
Control de Duplicados: Prevención de códigos de boleto duplicados
Gestión de Múltiples Salas: Soporte para hasta 10 salas de cine

Funcionalidades del Sistema
Registro de Boletos

Código único de boleto (con spinner numérico)
Nombre del comprador
Selección de película (mediante radio buttons)
Asignación de sala (1-10)
Precio del boleto
Número de asiento
Horarios disponibles (3:00 p.m., 6:30 p.m., 9:00 p.m., 11:30 p.m.)
Estado de pago

Gestión de Datos

Tabla de visualización de boletos registrados
Campos no editables en la tabla para integridad de datos
Función de limpieza de formulario
Validación completa antes del registro

Reportes y Facturas

Generación de reportes generales del sistema
Creación de facturas individuales por código de boleto
Archivos de salida para documentación

Tecnologías Utilizadas

Java SE: Lenguaje de programación principal
Swing: Framework para la interfaz gráfica de usuario
NetBeans: IDE de desarrollo (basado en los comentarios del código)

Estructura del Proyecto
com.mycompany.sistemagestionboletoscine_kembly/
├── InterfazBoletos.java          # Interfaz gráfica principal
├── GestorBoletos.java           # Lógica de negocio para gestión de boletos
├── GeneradorReportes.java       # Generación de reportes y facturas
├── Boleto.java                  # Modelo de datos del boleto
├── Pelicula.java               # Enum de películas disponibles
└── ValidadorDatos.java         # Utilidades de validación
└── SistemaGestionBoletosCine_Kembly.java         # Main

Uso del Sistema
Agregar un Boleto

Completar todos los campos del formulario
Seleccionar la película deseada
Elegir sala y horario
Marcar si el pago fue realizado
Hacer clic en "Agregar Boleto"

Generar Reportes

Hacer clic en "Generar Reporte" para obtener un reporte general del sistema

Generar Facturas

Hacer clic en "Generar Factura"
Ingresar el código del boleto cuando se solicite
El sistema generará la factura correspondiente

Limpiar Formulario

Usar el botón "Limpiar Campos" para resetear todos los campos

Validaciones del Sistema
El sistema incluye las siguientes validaciones:

Códigos únicos: No se permiten boletos con códigos duplicados
Campos obligatorios: Validación de nombre, precio y asiento
Formato numérico: Validación de campos numéricos (precio, código)
Datos consistentes: Verificación de integridad antes del registro

Características de la Interfaz

Diseño responsivo: Tamaño mínimo de ventana establecido
Organización clara: Separación entre formulario, botones y tabla
Feedback visual: Mensajes de éxito, error y advertencia
Tabla no editable: Protección de datos registrados
Controles intuitivos: Uso de spinners, combo boxes y radio buttons

Configuración
Horarios Disponibles
Por defecto, el sistema maneja los siguientes horarios:

3:00 p.m.
6:30 p.m.
9:00 p.m.
11:30 p.m.

Salas Disponibles
El sistema soporta salas numeradas del 1 al 10.

Moneda
El sistema utiliza colones costarricenses (₡) como moneda por defecto.

Notas de Desarrollo

Utiliza el patrón MVC (Model-View-Controller) para separar responsabilidades
Implementa ActionListener para manejo de eventos
Usa GridBagLayout para un diseño flexible del formulario
Incluye validación robusta de datos de entrada
