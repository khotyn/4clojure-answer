(fn [default-value mapping-keys]
       (letfn [(mapping-default
               [innter-default-value inner-mapping-keys]
               (if (not (= (count inner-mapping-keys) 0))
                 (assoc
                   (mapping-default innter-default-value (rest inner-mapping-keys))
                   (first inner-mapping-keys)
                   innter-default-value)))]
         (mapping-default default-value mapping-keys)))
