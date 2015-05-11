The Java compiler needs to know about all classes, but the JVM does not
=======================================================================

I thought this was interesting:

As long as you make sure that a Java class is available before calling its
methods or constructor(s), it only needs to be known to the Java *compiler*,
i. e. only at *compile time* -- and not necessarily at runtime as well. Also,
`import` statements using the name of the class and even declarations using
the (imported or fully qualified) class name are always fine -- even if the
class is not actually available at runtime.

I wrote some short example code to illustrate this. In `main/`, there
is the main class `ImportTest`. It is not part of any (explicit) package.
That class imports `test.Importee` and declares a private static member
variable of that type. It only instantiates an instance of `test.Importee`
and calls one of its methods if the first command line parameter is `true`.

- To compile, execute `javac */*.java` from the top-level directory.
- Now change into `main/` and do `java ImportTest`. This should work and
  print `I can run! Whee!`. Note that `test.Importee` is *not* present in
  the classpath.
- Now, from the same directory, do `java ImportTest true`. This will fail
  since `test.Importee` is not present in the classpath...
- That is fixed by `java -cp ..:. ImportTest true`: Now the JVM can access
  `test.Importee` and the program will run, successfully executing the calls
  to `test.Importee`. Neat!
