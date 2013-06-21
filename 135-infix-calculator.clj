(fn [& more]
	(letfn 
		[(step [coll]
			(if
				(seq coll)
				(if 
					(= 3 (count coll))
					((second coll) (first coll) (nth coll 2))
					(step
						(cons
							((second coll) (first coll) (nth coll 2))
							(drop 3 coll))))))]
		(step more)))