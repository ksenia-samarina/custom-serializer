generate_proto:
	SRC_DIR=./src/test/proto && \
    DST_DIR=./src/test/java/benchmarks/proto && \
	protoc -I=${SRC_DIR} --java_out=${DST_DIR} ${SRC_DIR}/person.proto

generate_avro:
	SCHEMA_SRC=./src/test/avro/person.json && \
	DST_DIR=./src/test/java/benchmarks/avro && \
	java -jar ./avro-tools-1.12.0.jar compile schema ${SCHEMA_SRC} ${DST_DIR}
