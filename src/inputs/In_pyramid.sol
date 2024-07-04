/*
    Calculate the number of blocks in a Pyramid base on it's base dimensions
    in number of blocks
*/

int layerBlocks;

int pyramidBlockCounter(int numBlocksOnSide)
begin
    int i;
    int totalBlocks = 0;

    for i=1 to numBlocksOnSide do
    begin
        layerBlocks = i*i;
        totalBlocks = totalBlocks + layerBlocks;
    end

    return totalBlocks;
end

void main()
begin

    int baseSide = 50;

    int totalBlocks = pyramidBlockCounter(baseSide);

    print "Total number of blocks in the pyramid: " + totalBlocks;
    //Expected: Total number of blocks in the pyramid: 42925


end