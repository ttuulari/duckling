(
 ; Context map
 {}

 ; Distance

 "3 kilometriä"
 "3 km"
 "3km"
 "3k"
 (distance 3 "kilometre" {:value 3000 :unit "metre"})

 "3.0 km"
 (distance 3.0 "kilometre" {:value 3000.0 :unit "metre"})

 "8 mailia"
 (distance 8 "mile" {:value 12872 :unit "metre"})

 "9m"
 (distance 9 "m")

 "2cm"
 "2 senttiä"
 "2 senttimetriä"
 (distance 2 "centimetre" {:value 0.02 :unit "metre"})

 ; Volume

 "250 millilitraa"
 "250ml"
 "250 ml"
 (volume  250 "millilitre" {:value 0.25 :unit "litre"})

 "2 litraa"
 (volume 2 "litre")

 "3 gallonaa"
 "3 gal"
 (volume 3 "gallon" {:value 11.355 :unit "litre"})

 "3 hehtolitraa"
 (volume 300 "litre" {:value 30 :unit "litre"})

 "puoli litraa"
 (volume 0.5 "litre")

 ; Quantity
 "kaksi paunaa lihaa"
 (quantity 2 "pound" "meat")

 "pauna"
 (quantity 1 "pound")

 "lihaa"
 (quantity 1 nil "meat")

 "3 kuppia sokeria"
 (quantity 3 "cup" "sugar")

 "30 neliömetriä"
 (area 30 "square meter")
)
