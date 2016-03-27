# my-monocle-sample

LensとかPrismとかISOとかが使えるScalaのライブラリ。

### Lens

たとえばcase classのパラメータの値を不変性を保持したまま変更したいときにLensを使う。Lens[S, A]とか、@Lensesを使うとか。

```scala
case class Example(s: String, i: Int)
val s = Lens[Example, String](_.s)(s => _.copy(s = s))
```

### Official

https://github.com/julien-truffaut/Monocle

### Commiter's blog

http://aoino.hatenablog.com/entry/2014/12/23/050932
