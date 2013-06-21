(fn [f coll]
	(letfn
		[(step [f coll]
			(if coll (lazy-seq (cons (f (first coll)) (step f (next coll))))))]
		(step f coll)))