# ¿Cómo contribuir a este proyecto?

1. Es recomendable tener instalado el IntelliJ con las extensiones de WebComponents
2. Es NECESARIO tener instalado y correctamente linkeado el nodjs para que Polymer funcione segir estos pasos
  * `sudo apt-get install nodejs nodejs-dev`.
  * `sudo gedit ~/.bashrc` y agregar el las últimas líneas `PATH=/usr/bin/nodejs:$PATH` y `NODE_PATH=/usr/bin/nodejs`.
  * `cd /usr/bin`.
  * `ln -s /usr/bin/nodejs node`.
3. Es necesario tener Maven insalado con `sudo apt-get install maven` valdría.
4. Instalar el JDK 1.8
 * `sudo add-apt-repository ppa:webupd8team/java`
 * `sudo apt-get update`
 * `sudo apt-get install oracle-java8-installer`
5. Para ejecutar el servidor es recomendable hacer un clean para que siempre se refresquen las páginas html al montar el servidor, el comando sería `mvn clean spring-boot:run`
