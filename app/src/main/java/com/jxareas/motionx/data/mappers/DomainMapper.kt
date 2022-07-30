package com.jxareas.motionx.data.mappers

import dagger.assisted.AssistedFactory


interface DomainMapper<S, D> {

    fun mapToDomain(entity : S) : D
    fun mapFromDomain(domain : D) : S

    fun mapAllToDomain(entities : List<S>) : List<D> =
        entities.map(this::mapToDomain)

    fun mapAllFromDomain(domains : List<D>) : List<S> =
        domains.map(this::mapFromDomain)


}