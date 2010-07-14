package registrocontrol.lib;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Imagen {

/**
*
* @param origen, ruta del archivo origen
* @param ancho
* @param alto
* @param destino,ruta del archivo destino
* @param mantener_proporciones, si al cambiar de tamao se mantienen las proporciones de ancho/alto
* @param aumentar_tamanio, true si la medida sugerida es mayor que las medidas originales, llevara el archivo a un tamao mayor
* @throws IOException
*/
public static Image scale(File origen, int ancho, int alto, boolean mantener_proporciones, boolean aumentar_tamano)
throws IOException {

BufferedImage bsrc = javax.imageio.ImageIO.read(origen);


BufferedImage bdest = new BufferedImage(ancho, alto, bsrc.getTransparency());
Graphics2D g = bdest.createGraphics();

int ancho_actual = bsrc.getWidth();
int alto_actual = bsrc.getHeight();
boolean pasar_a_escala_inferior = false;

if(mantener_proporciones){
if(ancho_actual>ancho){
alto = Math.round(ancho*alto_actual/ancho_actual);
pasar_a_escala_inferior = true;
}
if(alto_actual>alto){
ancho = Math.round(alto*ancho_actual/alto_actual);
pasar_a_escala_inferior = true;
}
}else{
if(ancho_actual>ancho || alto_actual>alto){
pasar_a_escala_inferior = true;
}
}
BufferedImage image;
java.awt.Image temp1=null;
if( pasar_a_escala_inferior ){
// La imagen es ms grande que el tamao deseado
temp1 = bsrc.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
image = new BufferedImage(ancho, alto, bsrc.getTransparency());
}else{
// La imagen es menor al tamao deseado
if(aumentar_tamano){
// Llevamos la imagen al tamao deseado
temp1 = bsrc.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
image = new BufferedImage(ancho, alto, bsrc.getTransparency());
}else{
// Mantenemos el tamao original de la imagen
temp1 = bsrc.getScaledInstance(ancho_actual, alto_actual, java.awt.Image.SCALE_SMOOTH);
image = new BufferedImage(ancho_actual, alto_actual, bsrc.getTransparency());
}
}
image.getGraphics().drawImage(temp1, 0, 0, null);

AffineTransform at = AffineTransform.getScaleInstance((double) ancho/bsrc.getWidth(), (double) alto / bsrc.getHeight());
g.drawRenderedImage(bsrc, at);

return image;
}



}


