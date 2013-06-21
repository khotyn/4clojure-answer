(fn [s] (letfn [(binary-tree? [s]
	(and
		(= (count s) 3)
		(let [a (second s) b (last s)]
			(and
				(or
					(nil? a)
					(and 
						(sequential? a)
						(binary-tree? a)))
				(or
					(nil? b)
					(and 
						(sequential? b)
						(binary-tree? b)))))))]
          (binary-tree? s)))