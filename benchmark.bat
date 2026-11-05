@echo off
chcp 65001 > nul
if not exist out mkdir out
javac -encoding UTF-8 -d out src\prototype\*.java
if errorlevel 1 (
    echo Erro na compilacao.
    pause
    exit /b 1
)
java -cp out prototype.BenchmarkPrototype
pause
