docker run -v "$PWD:/data" thrift thrift -o /data --gen rb /data/service.thrift