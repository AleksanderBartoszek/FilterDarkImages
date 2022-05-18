import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/** Returns directory accessible using provided path */
def getDirectory(path: String): File = {
  val resultFile = new File(path)
  resultFile
}

/** Converts BufferedImage to sequence of RGB values for each pixel */
def bufferedImageToData(bImg: BufferedImage): Seq[RGB] = {
  val rgb = for (x <- 0 until bImg.getWidth; y <- 0 until bImg.getHeight) yield bImg.getRGB(x, y)
  rgb.map(e => RGB((e & 0xff0000) / 65536, (e & 0xff00) / 256, e & 0xff))
}

/** Saves given image with scoring attached
 * 
 * @param image [BufferedImage] original image to be saved
 * @param folder place to store image
 * @param name [String] name of new file with scoring
 * @param format [String] format of a desired file ex. "jpg"
 */
def saveImageToFile(image: BufferedImage, folder: File, name: String, format: String): Unit = {
  val file = new File(folder, name)
  ImageIO.write(image, format, file)
}