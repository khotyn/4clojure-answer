(fn [init-num & functions]
  (reductions #(%2 %1) init-num (cycle functions)))