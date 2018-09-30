// trait : JavaのInterface

import com.dotinstall.model._

//class MyInt (){
//  def getThree(i: Int): Unit = {
//    println(s"$i $i $i ")
//  }
//}

class MyData[T] {
  def getThree(i: T): Unit = {
    println(s"$i $i $i ")
  }
}

object MyApp {
  def main(args:Array[String]) :Unit ={
    //var scores = List(200,300,400)
    //var scores = Nil
    var scores = 200 :: 300 :: 400 :: Nil

    println(scores.length)
    println(scores(1))
    println(scores.head)
    println(scores.tail)

    for (s <- scores) {
      println(s)
    }


  }
   //部分的用
   def msg(from :String,to :String,text :String) = {
     s"$from -> $to : $text"
   }

   def swap(a:Int , b:Int)  = (b,a*100)
}

