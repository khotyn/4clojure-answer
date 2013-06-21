(fn [& coll]
          (not
            (or
              (every? #(= true %) coll)
              (every? #(= false %) coll))))
