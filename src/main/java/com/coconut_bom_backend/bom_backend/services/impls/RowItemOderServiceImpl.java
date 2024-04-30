package com.coconut_bom_backend.bom_backend.services.impls;

import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemOrderRequestDto;
import com.coconut_bom_backend.bom_backend.entities.AddedTo;
import com.coconut_bom_backend.bom_backend.entities.RowItemOrder;
import com.coconut_bom_backend.bom_backend.repos.AddedToRepo;
import com.coconut_bom_backend.bom_backend.repos.RawItemOrderRepo;
import com.coconut_bom_backend.bom_backend.services.RowItemOderService;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class RowItemOderServiceImpl implements RowItemOderService {

    private final ModelMapper modelMapper;
    private  final AddedToRepo addedToRepo;
    private final RawItemOrderRepo rawItemOrderRepo;

    public RowItemOderServiceImpl(ModelMapper modelMapper, AddedToRepo addedToRepo, RawItemOrderRepo rawItemOrderRepo) {
        this.modelMapper = modelMapper;
        this.addedToRepo = addedToRepo;
        this.rawItemOrderRepo = rawItemOrderRepo;
    }

    @Override
    @Transactional
    public StandardResponse SaveRowItemOrder(ArrayList<RowItemOrderRequestDto> dtoList) {

        StandardResponse response = new StandardResponse();
        Double totalCost = 0.0;

        try {
            for (RowItemOrderRequestDto dto : dtoList) {
                addedToRepo.save(modelMapper.map(dto, AddedTo.class));
                totalCost = totalCost + dto.getQty()*dto.getUnitPrice();
                System.out.println(totalCost);
            }
            RowItemOrder rowItemOrder = new RowItemOrder();
            rowItemOrder.setTime(LocalTime.now());
            rowItemOrder.setDate( LocalDate.now());
            rowItemOrder.setTotalPrice(totalCost);

            System.out.println(rowItemOrder);

            rawItemOrderRepo.save(rowItemOrder);
        }

        catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            response.setData(null);
        }
        return response;
    }
}
