(fn [a  b] (set 
		(reduce concat
			(map
				(fn
					[eleA]
					(map
						(fn
							[eleB]
							(list eleA eleB))
						b))
				a))))