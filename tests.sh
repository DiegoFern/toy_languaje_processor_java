

#echo "compilando prueba1.plg" 
#java -cp ./bin programas.Compilador pruebas/prueba1.plg /tmp/prueba.compilado
#echo "ejecutando prueba1.plg"
#java -cp ./bin programas.Interprete /tmp/prueba.compilado

echo "compilando pruebas" 
java -cp ./bin programas.Compilador pruebas/prueba1.plg /tmp/prueba1.compilado
java -cp ./bin programas.Compilador pruebas/prueba2.plg /tmp/prueba2.compilado
java -cp ./bin programas.Compilador pruebas/prueba3.plg /tmp/prueba3.compilado

java -cp ./bin programas.Compilador pruebas/prueba4err.plg /tmp/prueba4.compilado
java -cp ./bin programas.Compilador pruebas/prueba5err.plg /tmp/prueba5.compilado
java -cp ./bin programas.Compilador pruebas/prueba6err.plg /tmp/prueba6.compilado
java -cp ./bin programas.Compilador pruebas/prueba7err.plg /tmp/prueba7.compilado
java -cp ./bin programas.Compilador pruebas/prueba8err.plg /tmp/prueba8.compilado
java -cp ./bin programas.Compilador pruebas/prueba9err.plg /tmp/prueba9.compilado
java -cp ./bin programas.Compilador pruebas/prueba10err.plg /tmp/prueba10.compilado

echo "ejecutando pruebas "

for file in `ls /tmp/*.compilado`; do
	echo ejecutando $file
	java -cp ./bin programas.Interprete $file
done

