<h2>1268. Search Suggestions System</h2><h3>Medium</h3><hr><div><p>Given an array of strings <code>products</code> and a string <code>searchWord</code>. We want to design a system that suggests at most three product names from <code>products</code>&nbsp;after each character of&nbsp;<code>searchWord</code> is typed. Suggested products should have common prefix with the searchWord. If there are&nbsp;more than three products with a common prefix&nbsp;return the three lexicographically minimums products.</p>

<p>Return <em>list of lists</em> of the suggested <code>products</code> after each character of&nbsp;<code>searchWord</code> is typed.&nbsp;</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
<strong>Output:</strong> [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
<strong>Explanation:</strong> products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> products = ["havana"], searchWord = "havana"
<strong>Output:</strong> [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
<strong>Output:</strong> [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> products = ["havana"], searchWord = "tatiana"
<strong>Output:</strong> [[],[],[],[],[],[],[]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= products.length &lt;= 1000</code></li>
	<li>There are no&nbsp;repeated elements in&nbsp;<code>products</code>.</li>
	<li><code>1 &lt;= Σ products[i].length &lt;= 2 * 10^4</code></li>
	<li>All characters of <code>products[i]</code> are lower-case English letters.</li>
	<li><code>1 &lt;= searchWord.length &lt;= 1000</code></li>
	<li>All characters of <code>searchWord</code>&nbsp;are lower-case English letters.</li>
</ul>
</div>