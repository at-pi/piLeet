<h2>1117. Building H2O</h2><h3>Medium</h3><hr><div><p>There are two kinds of threads, <code>oxygen</code> and <code>hydrogen</code>. Your goal is to group these threads to form water molecules.&nbsp;There is a barrier where each thread has to&nbsp;wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given <code>releaseHydrogen</code>&nbsp;and <code>releaseOxygen</code>&nbsp;methods respectively, which will allow them to pass the barrier. These threads should pass the barrier in groups of three, and they must be able to immediately bond with each other to form a water molecule.&nbsp;You must guarantee that all the threads from one molecule bond <em>before</em> any other threads from the next molecule do.</p>

<p>In other words:</p>

<ul>
	<li>If an oxygen thread arrives at the barrier when no hydrogen threads are present, it has to wait for two hydrogen threads.</li>
	<li>If a hydrogen thread arrives at the barrier when no other threads are present, it has to wait for an oxygen thread and another hydrogen thread.</li>
</ul>

<p>We don’t have to worry about matching the threads up explicitly; that is, the threads do not necessarily know which other threads they are paired up with. The key is just that threads pass the barrier in complete sets; thus, if we examine the sequence of threads that bond and divide them into groups of three, each group should contain one oxygen and two hydrogen threads.</p>

<p>Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.</p>

<div>
<p>&nbsp;</p>
</div>

<div>
<p><strong>Example 1:</strong></p>

<pre><strong>Input: </strong><span id="example-input-1-1">"HOH"</span>
<strong>Output: </strong><span id="example-output-1">"HHO"
<strong>Explanation:</strong> "HOH" and "OHH" are also valid answers.</span>
</pre>

<div>
<p><strong>Example 2:</strong></p>

<pre><strong>Input: </strong><span id="example-input-1-1">"OOHHHH"</span>
<strong>Output: </strong><span id="example-output-1">"HHOHHO"
<strong>Explanation:</strong> "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.</span>
</pre>
</div>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>Total length of input string will be 3<em>n</em>, where 1 ≤&nbsp;<em>n</em>&nbsp;≤ 20.</li>
	<li>Total number of <code>H</code> will be 2<em>n</em>&nbsp;in the input string.</li>
	<li>Total number of <code>O</code> will&nbsp;be <em>n</em>&nbsp;in the input&nbsp;string.</li>
</ul>
</div>