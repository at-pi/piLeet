<h2>1115. Print FooBar Alternately</h2><h3>Medium</h3><hr><div><p>Suppose you are given the following code:</p>

<pre>class FooBar {
  public void foo() {
&nbsp; &nbsp; for (int i = 0; i &lt; n; i++) {
&nbsp; &nbsp; &nbsp; print("foo");
&nbsp;   }
  }

  public void bar() {
&nbsp; &nbsp; for (int i = 0; i &lt; n; i++) {
&nbsp; &nbsp; &nbsp; print("bar");
&nbsp; &nbsp; }
  }
}
</pre>

<p>The same instance of <code>FooBar</code> will be passed to two different threads. Thread A will call&nbsp;<code>foo()</code> while thread B will call&nbsp;<code>bar()</code>.&nbsp;Modify the given program to output "foobar" <em>n</em> times.</p>

<p>&nbsp;</p>

<p><strong>Example 1:</strong></p>

<pre><b>Input:</b> n = 1
<b>Output:</b> "foobar"
<strong>Explanation:</strong> There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
</pre>

<p><strong>Example 2:</strong></p>

<pre><b>Input:</b> n = 2
<b>Output:</b> "foobarfoobar"
<strong>Explanation:</strong> "foobar" is being output 2 times.
</pre>
</div>