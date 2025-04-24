package br.com.erudio.exception.handler


class RequiredObjectIsNullException : RuntimeException {

    constructor():super("Persist null objects is not allowed")
    constructor(exception: String?):super(exception)

}