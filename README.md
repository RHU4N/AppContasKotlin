# AplicativoContas

Aplicativo Android desenvolvido em Kotlin para realizar cálculos de física, geometria, conversão de temperatura e diluição. A tela inicial funciona como um menu que direciona o usuário para calculadoras independentes.

## Funcionalidades

| Tela         | Cálculo                         | Fórmula                                             |
| ------------ | ------------------------------- | --------------------------------------------------- |
| `Velocidade` | Velocidade média                | `v = distância / tempo`                             |
| `Forca`      | Força resultante                | `F = massa × aceleração`                            |
| `Energia`    | Energia cinética                | `Ec = (massa × velocidade²) / 2`                    |
| `Fahrenheit` | Fahrenheit para Celsius         | `C = (F - 32) × 5 / 9`                              |
| `Celsius`    | Celsius para Fahrenheit         | `F = (C × 1,8) + 32`                                |
| `AreaPara`   | Área e volume de paralelepípedo | `A = 2 × (c × l + c × a + l × a)` e `V = c × l × a` |
| `Torricelli` | Velocidade final                | `vf = √(vi² + 2 × a × Δs)`                          |
| `Dilui`      | Relação de diluição             | `resultado = (C1 × V1) / (C2 × V2)`                 |

Os resultados são exibidos diretamente na tela, com mensagens para valores inválidos ou situações como divisão por zero e raiz negativa.

## Tecnologias

- Kotlin;
- Android SDK;
- AndroidX AppCompat, Activity, Core KTX e ConstraintLayout;
- Material Components;
- Gradle Kotlin DSL;
- JUnit e Espresso para testes.

## Requisitos

- Android Studio;
- Android SDK com compileSdk 36;
- JDK compatível com Java 11;
- dispositivo físico ou emulador com Android 7.0 (API 24) ou superior.

Configuração principal do aplicativo:

```text
Namespace: com.example.aplicativocontas
Application ID: com.example.aplicativocontas
Versão: 1.0 (versionCode 1)
Min SDK: 24
Target SDK: 36
```

## Estrutura do projeto

```text
AppContasKotlin/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew / gradlew.bat
└── app/
    ├── build.gradle.kts
    └── src/
        ├── main/
        │   ├── AndroidManifest.xml
        │   ├── java/com/example/aplicativocontas/
        │   │   ├── MainActivity.kt
        │   │   ├── Velocidade.kt
        │   │   ├── Forca.kt
        │   │   ├── Energia.kt
        │   │   ├── Fahrenheit.kt
        │   │   ├── Celsius.kt
        │   │   ├── AreaPara.kt
        │   │   ├── Torricelli.kt
        │   │   └── Dilui.kt
        │   └── res/
        │       ├── layout/       # Layout de cada tela
        │       ├── values/       # Cores, textos e temas
        │       └── mipmap*/       # Ícones do aplicativo
        ├── test/                 # Testes unitários
        └── androidTest/          # Testes instrumentados
```

## Como executar

1. Abra a pasta `AppContasKotlin` no Android Studio.
2. Aguarde a sincronização do Gradle.
3. Conecte um dispositivo Android ou inicie um emulador com API 24 ou superior.
4. Execute a configuração `app` pelo botão **Run**.

Também é possível compilar pelo terminal.

### Windows

```powershell
.\gradlew.bat assembleDebug
```

### Linux ou macOS

```bash
./gradlew assembleDebug
```

O APK de debug será gerado em:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Testes

Para executar os testes unitários:

```bash
./gradlew test
```

Para executar os testes instrumentados em um dispositivo ou emulador:

```bash
./gradlew connectedAndroidTest
```

No Windows, substitua `./gradlew` por `./gradlew.bat`.

## Observações

- As telas foram implementadas como `Activity`s independentes e são abertas pela `MainActivity`.
- Os cálculos usam valores decimais e exibem unidades como `m/s`, `N` e `Mol/L`.
- Algumas telas convertem diretamente o texto digitado para `Double`; entradas não numéricas podem encerrar o cálculo com erro em vez de exibir uma mensagem de validação.
- O aplicativo não utiliza servidor ou banco de dados: todos os cálculos são realizados localmente no dispositivo.

## Status

Projeto de estudo para praticar desenvolvimento Android com Kotlin, layouts XML, navegação entre Activities e implementação de fórmulas matemáticas.
