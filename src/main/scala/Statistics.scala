
/** Counts mean of given sequence */
def mean(seq: Seq[Double]): Double = seq.sum / seq.length

/** Difference between maximal and minimal value of sequence, currently unused */
def range(seq: Seq[Double]): Double = seq.max - seq.min

/** Counts median of given sequence (there is for sure better algorithm if needs be) */
def median(seq: Seq[Double]): Double = {
  val sortedSeq = seq.sorted
  if (sortedSeq.length % 2 == 0) {
    val (left, right) = sortedSeq.splitAt(sortedSeq.size / 2)
    (left.last + right.head) / 2
  }
  else sortedSeq(sortedSeq.length / 2)
}