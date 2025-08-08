Descripción

Esta aplicación, desarrollada como parte de los entregables de la Semana 12 de un curso de programación, es un proyecto simple en Android Studio con Kotlin que valida un correo electrónico ingresado por el usuario. La app presenta una interfaz limpia con un campo de texto para el correo y un mensaje dinámico que indica si el correo es válido o no. Si el correo cumple con el formato esperado (por ejemplo, contiene @ y un dominio válido), se muestra un mensaje de confirmación; de lo contrario, aparece un texto de error.

Características principales:

✨ Validación en tiempo real del formato de correo electrónico.
❌ Muestra un mensaje de error si el correo no contiene las características necesarias (por ejemplo, falta @ o dominio inválido).
✅ Feedback visual claro mediante un TextView que se actualiza al escribir.
Interfaz simple y responsiva usando Material Design.

Tecnologías

Herramienta

Android SDK
Kotlin
AndroidX Core
Material Components
Componentes de UI moderna

La aplicación sigue el patrón MVVM (Model-View-ViewModel) con una estructura simple:


MainActivity: Observa los cambios en el campo de texto y actualiza la UI.
MainViewModel: Maneja la lógica de validación del correo usando android.util.Patterns.EMAIL_ADDRESS.
activity_main.xml: Diseño con ConstraintLayout, TextInputEditText y TextView para mensajes.
Instalación y Configuración



Clona el Repositorio:

git clone https://github.com/r-leyton/semana_12.git
cd semana_12

Abrir en Android Studio:
Abre el proyecto en Android Studio (versión Giraffe o superior).
Asegúrate de tener configurado el SDK de Android (API 25 o superior).
Sincronizar Gradle:
Sincroniza el proyecto para descargar las dependencias (AndroidX, Material Components).
Si es necesario, verifica el archivo build.gradle para incluir:

dependencies {
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'com.google.android.material:material:1.12.0'
}

Ejecutar:

Conecta un dispositivo Android (5.0+) o usa un emulador.
Haz clic en el botón "Run" en Android Studio.

Capturas de Pantalla
<br>
<img width="250" height="auto" alt="image" src="https://github.com/user-attachments/assets/389cfd79-027d-433e-8217-1662ad913e44" />
<br>
CORREO NO VALIDO :
<br>
<img width="250" height="auto" alt="image" src="https://github.com/user-attachments/assets/fbc01823-fce2-4361-a0dd-1863207f702b" />
<br>
CORREO VALIDO:
<br>
<img width="250" height="auto" alt="image" src="https://github.com/user-attachments/assets/32a53dab-341a-4d3c-9626-9aefc7294dbc" />

