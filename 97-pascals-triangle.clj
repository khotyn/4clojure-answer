(fn [n]
	(letfn [(step [coll]
		(lazy-seq
			(cons
				coll
				(step
					((fn
						[coll] 
						(map 
							#(+ (first %) (second %))
							(partition 2 1 (concat '(0) coll '(0)))))
					coll)))))]
	(nth (step [1]) (dec n))))