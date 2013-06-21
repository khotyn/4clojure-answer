(fn [s]
	(letfn
		[(step [s n]
			(if s (cons (list (first s) n) (step (next s) (+ n 1))))
		)]
		(step s 0)))