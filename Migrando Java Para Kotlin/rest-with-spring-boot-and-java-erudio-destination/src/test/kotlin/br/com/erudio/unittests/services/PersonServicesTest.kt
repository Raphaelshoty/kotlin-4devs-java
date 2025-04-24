package br.com.erudio.unittests.services

import br.com.erudio.exception.handler.RequiredObjectIsNullException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import br.com.erudio.services.PersonServices
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension::class)
class PersonServicesTest {


    private var input: MockPerson? = null

    @InjectMocks
    private val service: PersonServices? = null

    @Mock
    private val repository: PersonRepository? = null

    @BeforeEach
    fun setupMock(){
        input = MockPerson()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testFindAll(){
        val list: List<Person> = input!!.mockEntityList()

        `when`(repository!!.findAll()).thenReturn(list)

        val persons = service!!.findAll()

        assertNotNull(persons)
        assertEquals(14, persons.size)

        val personOne = persons[1]
        assertNotNull(personOne)
        assertNotNull(personOne.id)

        assertEquals("Address Test1", personOne.address)
        assertEquals("First Name Test1", personOne.firstName)
        assertEquals("Female", personOne.gender)
        assertEquals("Last Name Test1", personOne.lastName)

        val personFour = persons[4]
        assertNotNull(personFour)
        assertNotNull(personFour.id)

        assertEquals("Address Test4", personFour.address)
        assertEquals("First Name Test4", personFour.firstName)
        assertEquals("Male", personFour.gender)
        assertEquals("Last Name Test4", personFour.lastName)

    }

    @Test
    fun testFindById(){

        val person: Person = input!!.mockEntity(1)

        `when`(repository?.findById(1)).thenReturn(Optional.of(person))

        var foundPerson: Person = service!!.findById(1)

        assertNotNull(foundPerson)
        assertNotNull(foundPerson.id)

        assertEquals("Address Test1",foundPerson.address)
        assertEquals("First Name Test1",foundPerson.firstName)
        assertEquals("Last Name Test1",foundPerson.lastName)
        assertEquals("Female",foundPerson.gender)

    }

    @Test
    fun testCreatePerson(){

        val person: Person = input!!.mockEntity(1)
        person.id = null

        val persisted = person.copy()
        persisted.id = 1

        `when`(repository?.save(person)).thenReturn(persisted)

        val result = service!!.create(person)

        assertNotNull(result)
        assertNotNull(result.id)

        assertEquals("First Name Test1", result.firstName)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("Female", result.gender)
        assertEquals("Address Test1", result.address)

    }

    @Test
    fun testCreateNullPerson(){
        val exception: Exception = assertThrows(RequiredObjectIsNullException::class.java){service!!.create(null)}

        val expectedMessage = "Persist null objects is not allowed"
        val actualMessage = exception.message

        assertEquals(expectedMessage, actualMessage)

    }

    @Test
    fun testUpdateWithNullPerson(){
        val exception: Exception = assertThrows(RequiredObjectIsNullException::class.java){service!!.update(null)}

        val expectedMessage = "Persist null objects is not allowed"
        val actualMessage = exception.message

        assertEquals(expectedMessage, actualMessage)

    }

    @Test
    fun testUpdatePerson(){

        val person: Person = input!!.mockEntity(1)

        val updated = person.copy()
        updated.id = 1
        updated.firstName = "Raphaela"

        `when`(repository?.findById(1)).thenReturn(Optional.of(person))
        `when`(repository?.save(person)).thenReturn(updated)

        val result = service!!.update(person)

        assertNotNull(result)
        assertNotNull(result.id)

        assertEquals("Raphaela", result.firstName)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("Female", result.gender)
        assertEquals("Address Test1", result.address)
    }

    @Test
    fun testDelete(){

        val person: Person = input!!.mockEntity(1)

        `when`(repository?.findById(1)).thenReturn(Optional.of(person))

         service!!.delete(1)
    }


}