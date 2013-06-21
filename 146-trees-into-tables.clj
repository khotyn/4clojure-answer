(fn [t]
	(apply hash-map
		(apply concat
			(apply concat 
				(for
					[key (keys t)]
					(for 
						[inner-key (keys (get t key))]
						[[key inner-key] (get (get t key) inner-key)]))))))