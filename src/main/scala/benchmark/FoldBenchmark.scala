package benchmark

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

import scala.collection.LinearSeq

@State(Scope.Benchmark)
class BenchmarkState {
  @Param(Array(
    "1000",
    "10000",
    "100000",
    "1000000",
    "10000000"))
  var inputSize: Int = _

  var testSeq: LinearSeq[Int] = _

  @Setup(Level.Trial)
  def prepare(): Unit = {
    testSeq = LinearSeq.range[Int](0, inputSize)
  }
}

class FoldBenchmark {
  @Benchmark
  def foldLeft1Baseline(state: BenchmarkState): Int = {
    state.testSeq.iterator.foldLeft(0)(_ + _ % 1001491)
  }

  @Benchmark
  def foldLeft2Baseline(state: BenchmarkState): Int = {
    state.testSeq.foldLeft(0)(_ + _ % 1001491)
  }
}
