@echo off
where gradle >nul 2>nul
if %errorlevel% neq 0 (
  echo Gradle no esta instalado o no esta en PATH.
  echo Abre el proyecto en IntelliJ como proyecto Gradle o instala Gradle 9.x.
  pause
  exit /b 1
)
gradle clean test aggregate
pause
