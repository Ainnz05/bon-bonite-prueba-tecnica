#!/usr/bin/env sh
set -e
if ! command -v gradle >/dev/null 2>&1; then
  echo "Gradle no está instalado. Importa el proyecto en IntelliJ o instala Gradle 9.x."
  exit 1
fi
gradle clean test aggregate
