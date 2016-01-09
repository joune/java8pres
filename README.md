# Plan

1. Lambda
2. Streaming API
3. Own functions
4. Either
5. Fold (reduce)
6. Lazy? How to show on this example?
7. Trampoline? How to show on this example?

# Refactorings

## NumberUtils

0. Multiple return statements, early abort
1. Replace with `str.chars()` but with an anonymous inner class. No early abort, pure declaration.
2. Change inner class by lambda. Lambda is a syntax sugar and nothing more. (Talk about closures and effective final?)
3. How lambdas are called, interface with single method
4. Change lambda with a method reference

0. Lambdas are often used in new Streaming API
1. OperatorsRegistry.of - creates a Map, fills in a Map, ... - refactor to use lambda
2. Still not good - creating an immutable collection at one place, filling it in later - can use Collectors.toMap
3. Explain streaming API
4. Explain Collector and Collectors

0. Main - use stream as well
1. It doesn't change a lot though
2. We don't have an explicit loop, but no clear benefit yet - let's keep and see how it pays off later

0. Design for lambdas - can also build own code for it
1. Make Operator interface "functional" - we don't use `designation()` outside of registration anyway
2. First, refactor the code to get it working again (for OperatorRegistry - allow passing a map)
3. Now, looking at Sum, Subtraction, etc. - they can be replaced with lambdas
4. Git diff - whole bunch of classes removed
4.1. Hint - Java 8 comes with a lot of "functional" interfaces. Look at Javadoc. Use Java's Operator. Git diff again.
5. AlgebraicOperators serves sharing those operators, so let's keep it. Don't like the Map stuff though.

0. Note: so far we were changing a lot of things, but only those which concern us. We didn't even touch the 
   Calculator class. Separation of concerns is cool and we're good at it. With new tools we are even better.
   
0. Now the Main - we have the exception... Why would we? Let's design a class for "result or error"
1. ResultOrError. Now we still have an if in the Main
2. Add `forEach` a function to it. Better we have this if inside now though.
3. Also, construction is not evident - do we pass result or error
4. Notice how Main became declarative now. Instead of telling to iterate and checking, we "define" what the output is.
5. Also, it seems to be a common need. Let's factorize - `Either`