@echo off
setLocal EnableDelayedExpansion
set CLASSPATH=
for /R ./lib %%a in (*.jar) do (
  set CLASSPATH=!CLASSPATH!;%%a
)
java -cp %CLASSPATH% in.xnnyygn.attic.interpreter.Launcher
