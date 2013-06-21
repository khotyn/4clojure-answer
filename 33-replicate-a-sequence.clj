(fn
          [coll n]
          (reduce
            concat
            (map
              #(repeat n %)
              coll)))
