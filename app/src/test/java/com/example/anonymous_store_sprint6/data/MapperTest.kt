package com.example.anonymous_store_sprint6.data


import com.example.anonymous_store_sprint6.data.remote.Cell
import com.example.anonymous_store_sprint6.data.remote.CellDetalle
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun transformar() {

        // Given
        val cell = Cell(1, "Example Cell", 500, "cell_image.jpg")

        // When
        val telefonoEntity = cell.transformar()

        // Then
        assertEquals(1, telefonoEntity.id)
        assertEquals("Example Cell", telefonoEntity.name)
        assertEquals(500, telefonoEntity.price) // Using a delta to account for floating-point precision
        assertEquals("cell_image.jpg", telefonoEntity.image)



    }

    @Test
    fun toDetalleEntity() {

        // Given
        val cellDetalle = CellDetalle(1,"Example Cell",500,"cell_image.jpg","A great cell phone",450,true)

        // When
        val telefonoDetalleEntity = cellDetalle.toDetalleEntity()

        // Then
        assertEquals(1, telefonoDetalleEntity.id)
        assertEquals("Example Cell", telefonoDetalleEntity.name)
        assertEquals(500, telefonoDetalleEntity.price) // Using a delta to account for floating-point precision
        assertEquals("cell_image.jpg", telefonoDetalleEntity.image)
        assertEquals("A great cell phone", telefonoDetalleEntity.description)
        assertEquals(450, telefonoDetalleEntity.lastPrice)
        assertTrue(telefonoDetalleEntity.credit)
    }
}