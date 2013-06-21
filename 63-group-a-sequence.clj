(fn [f coll]
	(apply
		merge-with
		concat
		(map
			#(assoc {} (f %) [%])
			coll)))