import javax.imageio.ImageIO

/** Entry point
 *
 * @param in path to folder with images to process
 * @param out path where images should be saved
 * @param threshold minimal score to discard image
 * @param func type of function to evaluate how bright is the image
 */
@main
def FilterDarkImages(in: String, out: String, threshold: Int, func: String): Unit = {
  val inputPath = in + "/"
  val outputPath = out + "/"
  val cutOff = threshold
  val function = func match {
    case "linear" => linear
    case "dark" => darkSteep
    case _ => commonSteep
  }

  for (e <- getDirectory(inputPath).listFiles) {
    val image = ImageIO.read(e)
    val data = bufferedImageToData(image)
    val pixelLightness = lightness(data)
    val points = score(function, mean(pixelLightness), median(pixelLightness))

    val format = e.getName.split("[.]+").last
    val name = e.getName.split("[.]+").head
    val outDir = getDirectory(outputPath)

    if(points < cutOff)
      saveImageToFile(image, outDir, name + "_bright_" + points + "." + format, format)
    else
      saveImageToFile(image, outDir, name + "_dark_" + points + "." + format, format)
  }
}