package com.github.baltiyskiy

import akka.NotUsed
import akka.kafka.ProducerMessage
import akka.kafka.ProducerSettings
import akka.kafka.javadsl.Producer
import akka.stream.javadsl.Flow

inline fun <reified T> flow(): Flow<T, T, NotUsed> = Flow.of(T::class.java)

class Test {
    private val settings: ProducerSettings<ByteArray, ByteArray> = TODO()
    val flow = flow<ProducerMessage.Envelope<ByteArray, ByteArray, Unit>>()
        .via<ProducerMessage.Results<ByteArray, ByteArray, Unit>, NotUsed>(Producer.flexiFlow(settings))

//  fun test() {
//    emptyList<String>()
//      .stream()
//      .collect(
//        Collectors.groupingBy(
//          Functions.identity(),
//          Collectors.counting()
//        )
//      )
//  }

}