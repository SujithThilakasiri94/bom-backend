package com.coconut_bom_backend.bom_backend.services.impls;

import com.coconut_bom_backend.bom_backend.dtos.dbModelDtos.AddedToModelDto;
import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemOrderRequestDto;
import com.coconut_bom_backend.bom_backend.entities.AddedTo;
import com.coconut_bom_backend.bom_backend.entities.RowItem;
import com.coconut_bom_backend.bom_backend.entities.RowItemOrder;
import com.coconut_bom_backend.bom_backend.repos.AddedToRepo;
import com.coconut_bom_backend.bom_backend.repos.RawItemOrderRepo;
import com.coconut_bom_backend.bom_backend.repos.RowItemRepo;
import com.coconut_bom_backend.bom_backend.services.RowItemOderService;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service

public class RowItemOderServiceImpl implements RowItemOderService {

    private  final AddedToRepo addedToRepo;
    private final RawItemOrderRepo rawItemOrderRepo;
    private final RowItemRepo rowItemRepo;

    public RowItemOderServiceImpl(ModelMapper modelMapper,
                                  AddedToRepo addedToRepo,
                                  RawItemOrderRepo rawItemOrderRepo,
                                  AddedToModelDto addedToModelDto,
                                  RowItemOrder rowItemOrder,
                                  AddedTo addedTo,
                                  RowItemRepo rowItemRepo) {

        this.addedToRepo = addedToRepo;
        this.rawItemOrderRepo = rawItemOrderRepo;
        this.rowItemRepo = rowItemRepo;
    }

    @Override
    @Transactional
    public StandardResponse SaveRowItemOrder(List<RowItemOrderRequestDto> dtoList) {

        StandardResponse response = new StandardResponse();
        double totalCost = 0.0;

        try {

            for (RowItemOrderRequestDto i : dtoList) {
                totalCost = totalCost + i.getUnitPrice()*i.getQuantity(); ;
            }

            // Create and save RowItemOrder
            RowItemOrder rowItemOrder = new RowItemOrder();
            rowItemOrder.setTime(LocalTime.now());
            rowItemOrder.setDate(LocalDate.now());
            rowItemOrder.setTotalPrice(totalCost);
            RowItemOrder itemOrder = rawItemOrderRepo.save(rowItemOrder);

            int lastId = rawItemOrderRepo.findLastIId();

            for (RowItemOrderRequestDto dto : dtoList) {

               RowItem x = rowItemRepo.findById(dto.getRowItemId()).get();

               AddedTo addedTo = new AddedTo();

                addedTo.setRowItemOrder(itemOrder);//oder id
                addedTo.setRowItem(x);
                addedTo.setQty(dto.getQuantity());
                addedTo.setUnitPrice(dto.getUnitPrice());
                addedToRepo.save(addedTo);

            }

            response.setCode(200);
            response.setMessage("Successfully placed the order");
            response.setSuccess(true);
            response.setData(rowItemOrder);
        }
        catch (Exception e){
            System.out.println("Running exception");
            response.setCode(500);
            response.setMessage(e.getMessage());
            response.setSuccess(false);
        }
        return response;
    }
}
