(fn [v] (letfn [(step [v]
	(lazy-seq
		(cons
			v
			(step
				((fn [w]
					(vec
						(map
							#(+ (first %) (second %))
							(partition 2 1 (concat '(0N) w '(0N))))))
				v)))))]
          (step v)))