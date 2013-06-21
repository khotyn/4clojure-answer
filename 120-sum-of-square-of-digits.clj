(fn [coll]
	(count
		(filter
			(fn [ele]
				(>
					((fn [num]
						(letfn
							[(step [num]
								(if
									(= num 0)
									0
									(+ (* (rem num 10) (rem num 10)) (step (quot num 10)))))]
							(step num)))
						ele)
					ele))
			coll)))