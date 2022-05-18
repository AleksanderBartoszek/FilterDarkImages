import javax.imageio.ImageIO

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