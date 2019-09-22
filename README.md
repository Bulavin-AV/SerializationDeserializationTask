Encoder
=======
This is Encoder for Serialization and Deserialization object.
## NonCircularReference
Uses for checking object references on resolving circular reference.
It's separate for using singly(for example if you want just check obect, use `NonCircularReference class`) 
and add Functional for this API.
## SuperEncoderImpl
Main class for Serialization and DeserializationTask.
Before Serialization its use  `NonCircularReference class`
