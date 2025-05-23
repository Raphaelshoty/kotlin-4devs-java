package br.com.erudio.integrationtests.controller

import br.com.erudio.configs.TestsConfig
import br.com.erudio.model.Person
import br.com.erudio.testContainers.AbstractIntegrationTest

import io.restassured.RestAssured.given
import io.restassured.builder.RequestSpecBuilder
import io.restassured.common.mapper.TypeRef
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.shaded.com.fasterxml.jackson.databind.DeserializationFeature
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonControllerTest : AbstractIntegrationTest() {

    private var specification: RequestSpecification? = null
    private var objectMapper: ObjectMapper? = null
    private var person: Person? = null


    @BeforeAll
    fun setup(){
        objectMapper = ObjectMapper()
        objectMapper!!.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        person = Person()
    }

    @Test
    @Order(1)
    fun postSetup(){
        specification = RequestSpecBuilder()
            .setBasePath("/person")
            .setPort(TestsConfig.SERVER_PORT)
            .addFilter(RequestLoggingFilter(LogDetail.ALL))
            .addFilter(ResponseLoggingFilter(LogDetail.ALL))
            .build()
    }

    @Test
    @Order(2)
    fun testCreate(){
        mockPerson()

        val content: String = given().spec(specification)
            .contentType(TestsConfig.CONTENT_TYPE)
            .body(person)
            .`when`()
            .post()
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString()
        val createdPerson = objectMapper!!.readValue(content, Person::class.java)

        person = createdPerson

        assertNotNull(createdPerson.id)
        assertNotNull(createdPerson.firstName)
        assertNotNull(createdPerson.lastName)
        assertNotNull(createdPerson.address)
        assertNotNull(createdPerson.gender)
        assertTrue(createdPerson.id!! > 0)

        assertEquals("Richard", createdPerson.firstName)
        assertEquals("Stallman", createdPerson.lastName)
        assertEquals("New York City, New York, US", createdPerson.address)
        assertEquals("Male", createdPerson.gender)
    }

    @Test
    @Order(3)
    fun testUpdate(){
        person!!.lastName = "Josileide"

        val content: String = given().spec(specification)
            .contentType(TestsConfig.CONTENT_TYPE)
            .body(person)
            .`when`()
            .put()
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString()
        val updatedPerson = objectMapper!!.readValue(content, Person::class.java)

        person = updatedPerson

        assertNotNull(updatedPerson.id)
        assertNotNull(updatedPerson.firstName)
        assertNotNull(updatedPerson.lastName)
        assertNotNull(updatedPerson.address)
        assertNotNull(updatedPerson.gender)
        assertTrue(updatedPerson.id!! > 0)

        assertEquals("Richard", updatedPerson.firstName)
        assertEquals("Josileide", updatedPerson.lastName)
        assertEquals("New York City, New York, US", updatedPerson.address)
        assertEquals("Male", updatedPerson.gender)
    }

    @Test
    @Order(4)
    fun testFindById(){

        val content: String = given().spec(specification)
            .contentType(TestsConfig.CONTENT_TYPE)
            .pathParam("id", person!!.id)
            .`when`()
            .get("/{id}")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString()
        val foundPerson = objectMapper!!.readValue(content, Person::class.java)

        person = foundPerson

        assertNotNull(foundPerson.id)
        assertNotNull(foundPerson.firstName)
        assertNotNull(foundPerson.lastName)
        assertNotNull(foundPerson.address)
        assertNotNull(foundPerson.gender)
        assertTrue(foundPerson.id!! > 0)

        assertEquals("Richard", foundPerson.firstName)
        assertEquals("Josileide", foundPerson.lastName)
        assertEquals("New York City, New York, US", foundPerson.address)
        assertEquals("Male", foundPerson.gender)
    }

    @Test
    @Order(5)
    fun testDeleteById(){

        given().spec(specification)
            .contentType(TestsConfig.CONTENT_TYPE)
            .pathParam("id", person!!.id)
            .`when`()
            .delete("/{id}")
            .then()
            .statusCode(204)

    }

    @Test
    @Order(6)
    fun testFindAll(){

        val content = given().spec(specification)
            .contentType(TestsConfig.CONTENT_TYPE)
            .`when`()
            .get()
            .then()
            .statusCode(200)
            .extract()
            .body()
            .`as`(object: TypeRef<java.util.List<Person?>?>(){})

        val foundPerson = content?.get(0)

        person = foundPerson

        assertNotNull(foundPerson!!.id)
        assertNotNull(foundPerson.firstName)
        assertNotNull(foundPerson.lastName)
        assertNotNull(foundPerson.address)
        assertNotNull(foundPerson.gender)
        assertTrue(foundPerson.id!! > 0)

        assertEquals("Leandro", foundPerson.firstName)
        assertEquals("Costa", foundPerson.lastName)
        assertEquals("Uberlândia - Minas Gerais - Brasil", foundPerson.address)
        assertEquals("Male", foundPerson.gender)

        val lastfoundPerson = content?.get(5)

        assertNotNull(lastfoundPerson!!.id)
        assertNotNull(lastfoundPerson.firstName)
        assertNotNull(lastfoundPerson.lastName)
        assertNotNull(lastfoundPerson.address)
        assertNotNull(lastfoundPerson.gender)
        assertTrue(lastfoundPerson.id!! > 0)

        assertEquals("Marcos", lastfoundPerson.firstName)
        assertEquals("Paulo", lastfoundPerson.lastName)
        assertEquals("Patos de Minas - Minas Gerais - Brasil", lastfoundPerson.address)
        assertEquals("Male", lastfoundPerson.gender)

    }

    private fun mockPerson() {
        person?.firstName = "Richard"
        person?.gender = "Male"
        person?.address = "New York City, New York, US"
        person?.lastName = "Stallman"
    }


}