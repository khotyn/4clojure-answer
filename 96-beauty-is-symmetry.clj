(fn [s]
	(let [a (second s) b (last s)]
		(letfn
			[(mirror [s]
				(let [x (second s) y (last s)]
					(if
						(and (nil? x) (nil? y))
						s
						(list (first s)
							(if (nil? y) y (mirror y))
							(if (nil? x) x (mirror x))))))]
			(= a (mirror b)))))