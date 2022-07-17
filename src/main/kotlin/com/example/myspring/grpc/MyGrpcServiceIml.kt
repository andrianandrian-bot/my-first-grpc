package com.example.myspring.grpc

import com.example.proto.Main
import com.example.proto.Main.MyMessageResponse
import com.example.proto.MyServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class MyGrpcServiceIml: MyServiceGrpc.MyServiceImplBase() {

    override fun myRequest(request: Main.MyMessage?, responseObserver: StreamObserver<MyMessageResponse>?) {
        super.myRequest(request, responseObserver)
        val response = MyMessageResponse.newBuilder()
            .apply {
                id = 1
                body = "dfdfdf"
                time = "sdfsdf"
            }.build()

        responseObserver?.onNext(response)
//        responseObserver?.onError(Throwable("dffdff"))
        responseObserver?.onCompleted()
    }

    override fun myRequestSecond(request: Main.MyMessage?, responseObserver: StreamObserver<MyMessageResponse>?) {
        super.myRequestSecond(request, responseObserver)
        val response = MyMessageResponse.newBuilder()
            .apply {
                id = 1
                body = "dfdfdf"
                time = "sdfsdf"
            }.build()

        responseObserver?.onNext(response)
//        responseObserver?.onError(Throwable("dffdff"))
        responseObserver?.onCompleted()
    }

}