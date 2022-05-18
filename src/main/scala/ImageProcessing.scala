
/** Measures lightness of given pixels
 *
 * @param rgb Sequence of pixels formatted as RGB
 * @return Sequence of doubles in range <0-255>
 */
def lightness(rgb: Seq[RGB]): Seq[Double] = rgb.map(e => (e.max() + e.min()) / 2)

/** Measures brightness of given pixels
 *
 * @param rgb Sequence of pixels formatted as RGB
 * @return Sequence of doubles in range <0-255>
 */
def brightness(rgb: Seq[RGB]): Seq[Double] = rgb.map(e => e.max())
